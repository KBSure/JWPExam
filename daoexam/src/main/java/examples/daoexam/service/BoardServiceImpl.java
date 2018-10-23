package examples.daoexam.service;

import examples.daoexam.dao.BoardDao;
import examples.daoexam.dto.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    BoardDao boardDao;

    public BoardServiceImpl(BoardDao boardDao){
        this.boardDao = boardDao;
    }

    @Override
    @Transactional
    public Board addBoard(Board board) {
        // board정보 저장, id값은 저장시 자동으로 생성
//        boardDao.addBoard(board);
        Long id = boardDao.addBoard(board);
        board.setId(id);
        return board;
    }

    @Override
    @Transactional
    public Board getBoard(Long id) {
        //1건 읽어오고
        //readCount를 수정
        boardDao.updateCount(id);
        Board board = boardDao.getBoard(id);
        return null;
    }

    @Override
    public List<Board> getBoards(Long start, Long end) {
        return boardDao.getBoards(start, end);
    }

}
