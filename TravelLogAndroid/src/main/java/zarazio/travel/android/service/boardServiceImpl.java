package zarazio.travel.android.service;

import java.util.List;
import java.util.StringTokenizer;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import zarazio.travel.android.bean.attachedFileDTO;
import zarazio.travel.android.bean.boardDTO;
import zarazio.travel.android.bean.hashTagDTO;
import zarazio.travel.android.dao.boardDAO;

@Service
public class boardServiceImpl implements boardService {

	@Inject
	private boardDAO dao;
	
	@Override
	public void insertBoard(boardDTO board) throws Exception {
		// TODO Auto-generated method stub
		dao.insertBoard(board);
	}

	@Override
	public void insertHash(hashTagDTO hash) throws Exception {
		// TODO Auto-generated method stub
		StringTokenizer st = new StringTokenizer(hash.getHash_Tag_Content()," ");
		while(st.hasMoreTokens()){
			hash.setHash_Tag_Content(st.nextToken());
			dao.insertHash(hash);
		}
	}

	@Override
	public int maxboard_Code() throws Exception {
		// TODO Auto-generated method stub
		return dao.maxboard_Code();
	}

	@Override
	public void insertFile(attachedFileDTO files) throws Exception {
		// TODO Auto-generated method stub
		dao.insertFile(files);
	}

	@Override
	public List<boardDTO> boardList() throws Exception {
		// TODO Auto-generated method stub
		return dao.boardList();
	}

}
