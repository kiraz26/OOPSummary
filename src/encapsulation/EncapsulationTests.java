package encapsulation;

import static org.junit.Assert.*;

import java.io.ObjectStreamClass;
import java.lang.reflect.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class EncapsulationTests {

	@Test
	public void MoviePrivateFieldsTest() {
		System.out.println("---MoviePrivateFieldsTest---");
		Movie movie = new Movie();

		Field[] fields = movie.getClass().getDeclaredFields();
		
		assertEquals(true,fields.length>=3);
		
		String[] exp = {"rating","name","year","genres"};
		String[] act = {fields[0].getName(),fields[1].getName(),fields[2].getName(),fields[3].getName()};
		
		assertArrayEquals(exp, act);

        for (Field field : fields) {
        		System.out.println(field.getName()+"-private?->"+Modifier.isPrivate(field.getModifiers())+ "->" + field.getType().toString());
        		if(Arrays.asList(exp).contains(field.getName()))
        			assertEquals(field.getName()+" not private",true,Modifier.isPrivate(field.getModifiers()));
        		
        		if(field.getName().equals("genres"))
        			assertEquals("interface java.util.List",field.getType().toString());
        		
        }
       
        System.out.println("----------------");
	}
	
	@Test
	public void MovieGetterSetterTest() {
		System.out.println("---MovieGetterSetterTest---");
		Movie movie = new Movie();

		Method[] methods = movie.getClass().getDeclaredMethods();
        String[] actArr = new String[methods.length];
        int idx = 0;
        for (Method method : methods) {
        		actArr[idx++] = method.getName();
		}
		
		List<String> exp = Arrays.asList("getName","setName","getRating","setRating","getYear","setYear");
		List<String> act = Arrays.asList(actArr);

        assertTrue(act.containsAll(act));
        
		for (Method method : methods) {
        		System.out.println(method.getName()+"-public?->"+Modifier.isPublic(method.getModifiers()));
            assertEquals(method.getName()+" not public",true,Modifier.isPublic(method.getModifiers()));
        }
		System.out.println("------------------");

	}
	
	@Test
	public void MovieStaticListTest() {
		assertEquals("[Comedy, Action, Adventure, Western, Historical, Thriller, Animation]"
				,Movie.getAvailibleGenres().toString());	
	}
	
	@Test
	public void MovieConstructorsTest() {
		System.out.println("---MovieConstructorsTest---");

		Movie movie = new Movie();
		Constructor[] constructors = movie.getClass().getDeclaredConstructors();

		assertEquals(2,constructors.length);
		int iidx=0;
		if((constructors[0].getParameterCount() == 0 && constructors[1].getParameterCount() == 3) ||
				(constructors[0].getParameterCount() == 3 && constructors[1].getParameterCount() == 0) ){
			iidx = constructors[0].getParameterCount() == 0 ? 1: 0;
		}else{
			fail("Constructors params mismatch");
		}
			
	
        String[] exp = {"double","class java.lang.String","int"};
        String[] act = new String[3];
        int idx = 0;
        for (Parameter param : constructors[iidx].getParameters()) {
        		act[idx++]=param.getType().toString();
		}
        
        assertArrayEquals(exp, act);
		
        System.out.println("Constructor args: " + Arrays.toString(act));
		System.out.println("----------------");
	}
	
	@Test
	public void MovieToStringTest() {
		Movie movie = new Movie(3.4, "Tiger", 2012);
		assertEquals("Movie [rating=3.4, name=Tiger, year=2012]",
				movie.toString());
	}
	
	@Test
	public void MovieStaticBlockTest() {
		Movie movie = new Movie();
	 	try {
	        Method method = ObjectStreamClass.class.getDeclaredMethod("hasStaticInitializer", Class.class);
	        method.setAccessible(true);
	        assertTrue( (boolean) method.invoke(null, Movie.class));
	        
	 	} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
	    }
	}
	
}
