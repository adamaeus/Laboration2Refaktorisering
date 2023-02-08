package Operations.Interfaces;

public interface Loadable<T> {


    void load(T object);

    void unLoad();

    double returnSize();

    T returnLast();

    String showStack();
}
