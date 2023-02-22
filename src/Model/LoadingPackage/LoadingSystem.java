package Model.LoadingPackage;

import java.util.ArrayDeque;
import java.util.Deque;

public class LoadingSystem <T> implements Loadable <T> {


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
}
