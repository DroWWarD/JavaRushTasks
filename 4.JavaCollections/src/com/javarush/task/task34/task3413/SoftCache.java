package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);

        //напишите тут ваш код
        if (!cacheMap.containsKey(key)){
            return null;
        }else {
            return softReference.get();
        }
    }

    public AnyObject put(Long key, AnyObject value) {

        AnyObject last = null;
        boolean flag = false;
        if (!cacheMap.containsKey(key)){
            flag = true;
        }else {
            last = cacheMap.get(key).get();
            cacheMap.get(key).clear();
        }
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        //напишите тут ваш код
        if (flag){
            return null;
        }else {
            return last;
        }
    }

    public AnyObject remove(Long key) {
        AnyObject last = null;
        boolean flag = false;
        if (!cacheMap.containsKey(key)){
            flag = true;
        }else {
            last = cacheMap.get(key).get();
            cacheMap.get(key).clear();
        }
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        if (flag){
            return null;
        }else {
            return last;
        }
        //напишите тут ваш код
    }
}