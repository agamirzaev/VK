package com.example.vkwall.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.vkwall.R;
import com.example.vkwall.data.model.Profile.ProfileStatus.FieldsSetStatus;
import com.example.vkwall.data.model.Profile.ProfileStatus.ResponseStatus;
import com.example.vkwall.mvp.status.GetStatusPresenter;
import com.example.vkwall.mvp.status.GetStatusView;
import com.example.vkwall.mvp.status.SetStatusPresenter;
import com.example.vkwall.mvp.status.SetStatusView;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.main.activity.ProfileActivity;
import com.example.vkwall.util.Input;
import com.example.vkwall.util.SharedPreference;


@SuppressLint("ValidFragment")
public class StatusFragment extends DialogFragment implements GetStatusView, SetStatusView {

    private GetStatusPresenter presenter;
    private SetStatusPresenter statusPresenter;

    private LayoutInflater layoutInflater;
    private AlertDialog.Builder builder;
    private View view;
    private EditText status_get;

    public StatusFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setCanceledOnTouchOutside(false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateDialog(savedInstanceState);
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(getActivity());
        layoutInflater = getActivity().getLayoutInflater();
        view = layoutInflater.inflate(R.layout.status_dialog_fragment, null);
        status_get = view.findViewById(R.id.status);

        statusPresenter = new SetStatusPresenter(((App) view.getContext().getApplicationContext()).getDataManager());
        statusPresenter.attachView(this);

        presenter = new GetStatusPresenter(((App) view.getContext().getApplicationContext()).getDataManager());
        presenter.attachView(this);
        presenter.loadStatusProfile(SharedPreference.loadToken(view.getContext()), "5.101");

        builder.setTitle("Статус");
        builder.setView(view);
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Input.hide(view.getContext());
                dismiss();
            }
        });

        builder.setPositiveButton("Сохранить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Input.hide(view.getContext());
                ((ProfileActivity) view.getContext()).showServices(status_get.getText().toString());
                statusPresenter.status(status_get.getText().toString(), SharedPreference.loadToken(view.getContext()), "5.101");
            }
        });

        return builder.create();
    }

    @Override
    public void showStatus(ResponseStatus responseStatus) {
        status_get.setText(responseStatus.getText());
        status_get.setSelection(status_get.getText().length());
    }

    @Override
    public void setStatus(FieldsSetStatus fieldsSetStatus) {
    }
}
