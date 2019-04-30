package soal;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import app.soal.function.DataStoreAndLoad;

public class DataStoreAndLoadTest {

	@Test
	public void store() {
		DataStoreAndLoad.store(DataStoreAndLoad.sampleDataArray());
	}
	
	@Test
	public void load() {
		DataStoreAndLoad.load(DataStoreAndLoad.store(DataStoreAndLoad.sampleDataArray()));
	}
	
	@Test
	public void both() {
		DataStoreAndLoad.store(DataStoreAndLoad.sampleDataArray());
		Map<String, String>[] res = DataStoreAndLoad.load(DataStoreAndLoad.store(DataStoreAndLoad.sampleDataArray()));
		Assert.assertEquals(res, DataStoreAndLoad.sampleDataArray());
	}
}
