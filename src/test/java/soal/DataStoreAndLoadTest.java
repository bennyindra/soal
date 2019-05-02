package soal;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app.soal.function.DataStoreAndLoad;

public class DataStoreAndLoadTest {

	private Map<String, String>[] array;
	
	private String serializedArray ;
	
	@SuppressWarnings("unchecked")
	@Before
	public void before(){
		array = new HashMap[10];

		for (int j = 0; j < 10; j++) {
			Map<String, String> map = new HashMap<>();
			for (int i = 1; i <= 2; i++) {
				map.put(DataStoreAndLoad.KEY + j+i, DataStoreAndLoad.VALUE + j+i);
			}
			array[j] = map;
		}
		
		serializedArray = "KEY02=VALUE02;KEY01=VALUE01\\nKEY12=VALUE12;KEY11=VALUE11\\nKEY22=VALUE22;KEY21=VALUE21\\nKEY31=VALUE31;KEY32=VALUE32\\nKEY42=VALUE42;KEY41=VALUE41\\nKEY51=VALUE51;KEY52=VALUE52\\nKEY62=VALUE62;KEY61=VALUE61\\nKEY71=VALUE71;KEY72=VALUE72\\nKEY82=VALUE82;KEY81=VALUE81\\nKEY91=VALUE91;KEY92=VALUE92\\n";
	}
	
	@Test
	public void testStore() {
		assertEquals(serializedArray, DataStoreAndLoad.store(array));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testLoad() {
		assertEquals(array, DataStoreAndLoad.load(serializedArray));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testBoth() {
		DataStoreAndLoad.store(array);
		Map<String, String>[] res = DataStoreAndLoad.load(DataStoreAndLoad.store(array));
		Assert.assertEquals(res, array);
	}
}
