package tests.model;

import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.rits.cloning.Cloner;

import model.TestBean;

public class CopyTest {
	
	 
	@Test
	public void testQuestion() throws CloneNotSupportedException   {
		 TestBean tmp = new TestBean();
		 tmp.setName("aaaa");
		 tmp.setQuestion("question");
		 
		 TestBean copy = tmp.clone();
		 copy.setQuestion("change");
		 
		 assertNotEquals(tmp.getQuestion(), copy.getQuestion());
		 
		 System.out.println("tmp: "+ tmp.getQuestion() + " copy: " + copy.getQuestion());
		 
	}
	
	@Test
	public void testName() throws CloneNotSupportedException   {
		 TestBean tmp = new TestBean();
		 tmp.setName("aaaa");
		 
		 TestBean copy = tmp.clone();
		 
		 assertEquals(tmp.getName(), copy.getName());
		 copy.setName("new");
		 assertNotEquals(tmp.getName(), copy.getName());
		 
		 System.out.println("tmp: "+ tmp.getName() + " copy: " + copy.getName());
		 
	}
	
	
	 

}
