package data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    public MutableLiveData<String> isSelected=new MutableLiveData<>();
    public MutableLiveData<Boolean> isSelect=new MutableLiveData<>();

}
