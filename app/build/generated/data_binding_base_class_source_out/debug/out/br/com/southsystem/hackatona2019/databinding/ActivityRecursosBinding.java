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

public abstract class ActivityRecursosBinding extends ViewDataBinding {
  @NonNull
  public final TextView acessibilidade;

  @NonNull
  public final TextView acessibilidadeView;

  @NonNull
  public final TextView agua;

  @NonNull
  public final TextView aguaView;

  @NonNull
  public final TextView apoio;

  @NonNull
  public final TextView apoioView;

  @NonNull
  public final TextView bombeiros;

  @NonNull
  public final TextView bombeirosView;

  @NonNull
  public final TextView cidade;

  @NonNull
  public final TextView internet;

  @NonNull
  public final TextView internetView;

  @NonNull
  public final TextView luz;

  @NonNull
  public final TextView luzView;

  @NonNull
  public final TextView populacaoView;

  @NonNull
  public final TextView saneamento;

  @NonNull
  public final TextView saneamentoView;

  @NonNull
  public final TextView saude;

  @NonNull
  public final TextView telefonia;

  @NonNull
  public final TextView telefoniaView;

  @NonNull
  public final TextView titulo;

  protected ActivityRecursosBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView acessibilidade, TextView acessibilidadeView, TextView agua, TextView aguaView,
      TextView apoio, TextView apoioView, TextView bombeiros, TextView bombeirosView,
      TextView cidade, TextView internet, TextView internetView, TextView luz, TextView luzView,
      TextView populacaoView, TextView saneamento, TextView saneamentoView, TextView saude,
      TextView telefonia, TextView telefoniaView, TextView titulo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.acessibilidade = acessibilidade;
    this.acessibilidadeView = acessibilidadeView;
    this.agua = agua;
    this.aguaView = aguaView;
    this.apoio = apoio;
    this.apoioView = apoioView;
    this.bombeiros = bombeiros;
    this.bombeirosView = bombeirosView;
    this.cidade = cidade;
    this.internet = internet;
    this.internetView = internetView;
    this.luz = luz;
    this.luzView = luzView;
    this.populacaoView = populacaoView;
    this.saneamento = saneamento;
    this.saneamentoView = saneamentoView;
    this.saude = saude;
    this.telefonia = telefonia;
    this.telefoniaView = telefoniaView;
    this.titulo = titulo;
  }

  @NonNull
  public static ActivityRecursosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_recursos, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRecursosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityRecursosBinding>inflateInternal(inflater, R.layout.activity_recursos, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityRecursosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_recursos, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRecursosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityRecursosBinding>inflateInternal(inflater, R.layout.activity_recursos, null, false, component);
  }

  public static ActivityRecursosBinding bind(@NonNull View view) {
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
  public static ActivityRecursosBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityRecursosBinding)bind(component, view, R.layout.activity_recursos);
  }
}