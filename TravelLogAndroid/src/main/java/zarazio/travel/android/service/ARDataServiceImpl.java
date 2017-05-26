package zarazio.travel.android.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import zarazio.travel.android.bean.ARDataInfo;
import zarazio.travel.android.dao.ARDataDAO;

@Service
public class ARDataServiceImpl implements ARDataService {

	@Inject
	private ARDataDAO dao ;
	
	@Override
	public List<ARDataInfo> ARDatalist() throws Exception {
		// TODO Auto-generated method stub
		return dao.ARDatalist();
	}

}
