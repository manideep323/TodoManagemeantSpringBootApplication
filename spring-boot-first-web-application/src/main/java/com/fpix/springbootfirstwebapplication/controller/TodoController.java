package com.fpix.springbootfirstwebapplication.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fpix.springbootfirstwebapplication.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

@Autowired
public TodoService todoService;
@RequestMapping(value="/list-todo",method=RequestMethod.GET)
public String showTodoList(ModelMap model) {
		String name = (String) model.get("name");
	model.put("todos",todoService.retrieveTodos(name));
	return "list-todos";
	
}

@RequestMapping(value="/add-todo",method=RequestMethod.GET)
public String showAddTodoPage(ModelMap model) {
	return "add-todo";
	
}
@RequestMapping(value="/add-todo",method=RequestMethod.POST)
public String addTodo(ModelMap model,@RequestParam String desc) {
	todoService.addTodo((String)model.get("name"), desc, new Date(), false);
	String name = (String) model.get("name");
	model.put("todos",todoService.retrieveTodos(name));
	return "list-todos";
	
}	
@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
public String deleteTodo(ModelMap model,@RequestParam int id) {
	todoService.deleteTodo(id);
	String name = (String) model.get("name");
	model.put("todos",todoService.retrieveTodos(name));
	return "list-todos";
	
}		
}
