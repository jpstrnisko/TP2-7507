package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;

public class FooTest {

	@Test
	public void doFooShouldReturnFoo(){
        Foo foo = new Foo();
        String result = foo.doFoo();
        Assert.assertEquals("Foo", result);
	}
	
	
	@Test
	public void doBarShouldReturnBar(){
        Foo foo = new Foo();
        String result = foo.doBar();
        Assert.assertEquals("Bar", result);
	}
	
	@Test
	public void doLoopShouldReturn3(){
		Foo foo = new Foo();
        int result = foo.doLoop();
        Assert.assertEquals(3, result);
	}
	@Test
	public void algo3ShouldReturnTP2ALGO3() {
		Foo foo = new Foo();
		String result = foo.algo3();
		Assert.assertEquals("TP2-ALGO3", result);
	}

}
