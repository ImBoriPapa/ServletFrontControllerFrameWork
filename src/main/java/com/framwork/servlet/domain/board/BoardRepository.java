package com.framwork.servlet.domain.board;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardRepository {
    private static Map<Long, Board> store = new HashMap<>();
    private static long sequence = 0L;

    private static final BoardRepository instance = new BoardRepository();

    public static  BoardRepository getInstance(){
        return instance;
    }

    private BoardRepository(){

    }

    public Board save(Board Board){
        Board.setId(++sequence);
        store.put(Board.getId(), Board);
        return Board;
    }

    public Board findById(Long id){
        return store.get(id);
    }

    public List<Board> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
