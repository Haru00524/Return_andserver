package zarazio.travel.android.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import zarazio.travel.android.bean.boardDTO;
import zarazio.travel.android.bean.myPlaceDTO;
import zarazio.travel.android.dao.QNADAO;

@Service
public class QNAServiceImpl implements QNAService {
	
	@Inject
	private QNADAO dao ;
	@Override
	public int boardserch(myPlaceDTO myplace) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("dd");
		return dao.boardserch(myplace);
	}

}
