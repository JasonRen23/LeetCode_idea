package LeetCode_idea.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap <T extends Comparable<T>>{
    private List<T> items;

    private int cursor;

    public MaxHeap(){
        this(32);
    }
    public MaxHeap(int size){
        items = new ArrayList<>(size);
        cursor = -1;
    }

    public void shiftUp(int index){
        T intent = items.get(index);

        while (index > 0){
            int parentIndex  = (index - 1)/2;
            T parent = items.get(parentIndex);
            if(intent.compareTo(parent) > 0){//if intent is larger than parent
                items.set(index, parent);
                index = parentIndex;
            }else {
                break;
            }
        }

        items.set(index, intent);
    }

    public void shiftDown(int index){
        T intent = items.get(index);
        int leftIndex = 2 * index + 1;


        while(leftIndex < items.size()){
            T maxChild = items.get(leftIndex);
            int maxIndex = leftIndex;


            int rightIndex = leftIndex + 1;
            if(rightIndex < items.size()){
                T rightChild = items.get(rightIndex);
                if(rightChild.compareTo(maxChild) > 0){
                    maxChild = rightChild;
                    maxIndex = rightIndex;
                }
            }


            if(maxChild.compareTo(intent) > 0){
                items.set(index, maxChild);
                index = maxIndex;
                leftIndex = index * 2 + 1;
            }else {
                break;
            }
        }

        items.set(index, intent);
    }


    public void add(T item){
        items.add(item);
        shiftUp(items.size() - 1);
    }

    public T delteTop(){
        if(items.isEmpty()){
            throw new RuntimeException("The heap is empty!");
        }

        T maxItem = items.get(0);
        T lastItem = items.remove(items.size() - 1);
        if(items.isEmpty()){
            return lastItem;
        }

        items.set(0, lastItem);
        shiftDown(0);
        return  maxItem;
    }

    public T next(){
        if(cursor >= items.size()){
            throw new RuntimeException("No more element!");
        }
        return items.get(cursor);
    }

    public boolean hasNext(){
        cursor++;
        return cursor < items.size();
    }

    public T first(){
        if(items.size() == 0){
            throw new RuntimeException("The heap is empty!");
        }
        return items.get(0);
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public int size(){
        return items.size();
    }

    public void clear(){
        items.clear();
    }

    @Override
    public String toString(){
        return items.toString();
    }
}
