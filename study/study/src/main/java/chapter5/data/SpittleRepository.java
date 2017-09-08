package chapter5.data;

import java.util.List;
import chapter5.pojo.Spittle;

public interface SpittleRepository {
	List<Spittle> findRecentSpittles();
    List<Spittle> findSpittles(long max,int count);
    Spittle findOne(long id);
    void save(Spittle spittle);
}
