	Benchmark                        Mode  Samples    Score  Score error  Units
	c.i.MyBenchmark.testMaps         thrpt        5  179.373       11.926  ops/s
	c.i.MyBenchmark.testNodes        thrpt        5  210.943        9.324  ops/s
	c.i.MyBenchmark.testArrayNode    thrpt        5  154.871        8.230  ops/s
	c.i.MyBenchmark.testGson         thrpt        5  94.654        7.013  ops/s
	
	....[Thread state: RUNNABLE]........................................................................
	 34.7%  38.1% com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer.deserializeObject
	 24.9%  27.3% com.fasterxml.jackson.databind.node.ObjectNode.serialize
	 16.4%  18.0% com.fasterxml.jackson.core.json.ReaderBasedJsonParser._skipComma
	  3.6%   3.9% java.io.ByteArrayOutputStream.ensureCapacity
	  3.1%   3.3% com.fasterxml.jackson.databind.ObjectMapper.readTree
	  2.2%   2.4% com.fasterxml.jackson.core.json.ReaderBasedJsonParser._parsePosNumber
	  1.4%   1.5% java.util.HashMap.putVal
	  1.2%   1.3% com.ivagulin.MyBenchmark.testNodes
	  1.0%   1.1% java.util.HashMap.resize
	  0.7%   0.7% com.fasterxml.jackson.core.json.ReaderBasedJsonParser._skipWSOrEnd
	  2.0%   2.2% <other>
	