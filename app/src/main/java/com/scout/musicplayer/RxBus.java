package com.scout.musicplayer;

/**
 * Created by Jane on 2016/8/12.
 */

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * RxBus
 * Created by YoKeyword on 2015/6/17.
 */
public class RxBus {

    private final Subject<Object,Object> bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o){
        bus.onNext(o);
    }

    public Observable toObserverable(){
        return bus;
    }

}
