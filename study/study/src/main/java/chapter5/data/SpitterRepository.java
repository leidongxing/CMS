package chapter5.data;

import chapter5.pojo.Spitter;

public interface SpitterRepository {
   Spitter save(Spitter spitter);
   Spitter findByUsername(String username);
}
