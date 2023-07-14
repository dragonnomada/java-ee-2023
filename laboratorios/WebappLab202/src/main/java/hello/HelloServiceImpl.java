package hello;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HelloServiceImpl implements HelloService {

	private static Map<Integer,Hello> hellos = new HashMap<Integer, Hello>();
	
	public boolean addHello(Hello hello) {
		if(hellos.get(hello.getId()) != null) return false;
		hellos.put(hello.getId(), hello);
		return true;
	}

	public Hello[] getAllHello() {
		Set<Integer> ids = hellos.keySet();
		Hello[] helloArray = new Hello[ids.size()];
		int i = 0;
		for (Hello hello : hellos.values()) {
			helloArray[i++] = hello;
		}
		return helloArray;
	}

}
