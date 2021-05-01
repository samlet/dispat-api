package com.bluecc.dispat.computable;
import com.redislabs.modules.rejson.Path;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import com.redislabs.modules.rejson.JReJSON;
public class RedisJsonTest {
    @Test
    public void testRedisJson(){
        // First get a connection
        JReJSON client = new JReJSON("localhost", 6379);

        // Setting a Redis key name _foo_ to the string _"bar"_, and reading it back
//        client.set("foo", "bar");
//        String s0 = (String) client.get("foo");

        // Omitting the path (usually) defaults to the root path, so the call above to
        // `get()` and the following ones // are basically interchangeable
//        String s1 = (String) client.get("foo", new Path("."));
//        String s2 = (String) client.get("foo", Path.ROOT_PATH);

        // Any Gson-able object can be set and updated
        client.set("obj", new Object());             // just an empty object
        client.set("obj", null, new Path(".zilch"));
        Path p = new Path(".whatevs");
        client.set("obj", true, p);
        client.set("obj", 42, p);

        Object s0 = client.get("obj",Integer.class, p);
        System.out.println(s0);

        client.del("obj", p);                        // back to almost nothing
    }
}
