package com.domin.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Nashorn {

	public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
		ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");  
        // Reading Nashorn file  
		// Bindings bind = ee.getBindings(ScriptContext.ENGINE_SCOPE);  
	     //   bind.put("msg", "Nashorn");  
		ee.eval(new FileReader("src/com/domin/nashorn/hello.js"));  
        
       // ee.eval("print('Hello Nashorn');");  
		 Invocable invocable = (Invocable)ee;  
	        // calling a function  
		 Object a=   invocable.invokeFunction("hello","Hi","B");  
		 System.out.println(a);
	        // calling a function and passing variable as well.  
	}

}
