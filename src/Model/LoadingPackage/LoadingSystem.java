package Model.LoadingPackage;

import java.util.ArrayDeque;
import java.util.Deque;

public class LoadingSystem <T> implements Loadable <T> {



    private final int open = 1;
    private final int closed = 0;



    private Deque<T> loadedDeque = new ArrayDeque<>();

    @Override
    public void load(T object) {
        loadedDeque.push(object);
    }

    @Override
    public void unLoad() {
        T lastLoaded = loadedDeque.peek();
        assert lastLoaded != null;
        loadedDeque.pop();
    }

    @Override
    public double returnSize() {
        return loadedDeque.size();
    }


    public T returnLast(){
        return loadedDeque.peek();
    }

    public String showStack() {
        return loadedDeque.toString();
    }

   protected int openLoadingSystem() {
        return open;
    }
   protected int closeLoadingSystem() {
        return closed;
    }

}
