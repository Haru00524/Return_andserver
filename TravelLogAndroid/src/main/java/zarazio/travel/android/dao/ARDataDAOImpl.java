package zarazio.travel.android.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import zarazio.travel.android.bean.ARDataInfo;

@Repository 
public class ARDataDAOImpl implements ARDataDAO {

public static final String namespace = "travel.android.ARDataMapper" ;
	
	@Inject
	private SqlSession sql;
	
	@Override
	public List<ARDataInfo> ARDatalist() throws Exception {
		return sql.selectList(namespace+".select");
		// TODO Auto-generated method stub

	}

}
