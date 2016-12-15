package pl.krystiankaniowski.stackoverflowexplorer.mvp;


public interface BaseView<Presenter extends BasePresenter> {

    void setPresenter(Presenter presenter);

}
