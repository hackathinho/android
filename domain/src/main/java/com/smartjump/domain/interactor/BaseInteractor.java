package com.smartjump.domain.interactor;

import com.smartjump.domain.MainThread;
import com.smartjump.domain.ThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */
abstract class BaseInteractor<T, P> {

    private final MainThread mainThread;
    private final ThreadExecutor threadExecutor;
    private final CompositeDisposable compositeDisposable;

    BaseInteractor(MainThread mainThread, ThreadExecutor threadExecutor) {
        this.mainThread = mainThread;
        this.threadExecutor = threadExecutor;
        this.compositeDisposable = new CompositeDisposable();
    }

    abstract Observable<T> result(P params);

    public void execute(DisposableObserver<T> subscriber, P params) {
        Observable<T> observable = result(params).subscribeOn(mainThread.scheduler()).observeOn(Schedulers.from(threadExecutor));
        compositeDisposable.add(observable.subscribeWith(subscriber));
    }

    public void close() {
        if (!compositeDisposable.isDisposed()) compositeDisposable.dispose();
    }
}
