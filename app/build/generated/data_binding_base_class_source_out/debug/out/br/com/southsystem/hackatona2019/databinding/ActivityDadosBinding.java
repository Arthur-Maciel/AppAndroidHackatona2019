// Generated by data binding compiler. Do not edit!
package br.com.southsystem.hackatona2019.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import br.com.southsystem.hackatona2019.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityDadosBinding extends ViewDataBinding {
  @NonNull
  public final TextView cidade;

  @NonNull
  public final TextView clienteContatoView;

  @NonNull
  public final TextView geo;

  @NonNull
  public final TextView populacao;

  @NonNull
  public final TextView populacaoView;

  @NonNull
  public final TextView titulo;

  protected ActivityDadosBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView cidade, TextView clienteContatoView, TextView geo, TextView populacao,
      TextView populacaoView, TextView titulo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cidade = cidade;
    this.clienteContatoView = clienteContatoView;
    this.geo = geo;
    this.populacao = populacao;
    this.populacaoView = populacaoView;
    this.titulo = titulo;
  }

  @NonNull
  public static ActivityDadosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_dados, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityDadosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityDadosBinding>inflateInternal(inflater, R.layout.activity_dados, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityDadosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_dados, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityDadosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityDadosBinding>inflateInternal(inflater, R.layout.activity_dados, null, false, component);
  }

  public static ActivityDadosBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityDadosBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityDadosBinding)bind(component, view, R.layout.activity_dados);
  }
}
