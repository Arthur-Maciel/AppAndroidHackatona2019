package br.com.southsystem.hackatona2019;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import br.com.southsystem.hackatona2019.databinding.ActivityComentarioBindingImpl;
import br.com.southsystem.hackatona2019.databinding.ActivityDadosBindingImpl;
import br.com.southsystem.hackatona2019.databinding.ActivityHistoricoBindingImpl;
import br.com.southsystem.hackatona2019.databinding.ActivityRecursosBindingImpl;
import br.com.southsystem.hackatona2019.databinding.ItemListaBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCOMENTARIO = 1;

  private static final int LAYOUT_ACTIVITYDADOS = 2;

  private static final int LAYOUT_ACTIVITYHISTORICO = 3;

  private static final int LAYOUT_ACTIVITYRECURSOS = 4;

  private static final int LAYOUT_ITEMLISTA = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(br.com.southsystem.hackatona2019.R.layout.activity_comentario, LAYOUT_ACTIVITYCOMENTARIO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(br.com.southsystem.hackatona2019.R.layout.activity_dados, LAYOUT_ACTIVITYDADOS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(br.com.southsystem.hackatona2019.R.layout.activity_historico, LAYOUT_ACTIVITYHISTORICO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(br.com.southsystem.hackatona2019.R.layout.activity_recursos, LAYOUT_ACTIVITYRECURSOS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(br.com.southsystem.hackatona2019.R.layout.item_lista, LAYOUT_ITEMLISTA);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYCOMENTARIO: {
          if ("layout/activity_comentario_0".equals(tag)) {
            return new ActivityComentarioBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_comentario is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYDADOS: {
          if ("layout/activity_dados_0".equals(tag)) {
            return new ActivityDadosBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_dados is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYHISTORICO: {
          if ("layout/activity_historico_0".equals(tag)) {
            return new ActivityHistoricoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_historico is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYRECURSOS: {
          if ("layout/activity_recursos_0".equals(tag)) {
            return new ActivityRecursosBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_recursos is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMLISTA: {
          if ("layout/item_lista_0".equals(tag)) {
            return new ItemListaBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_lista is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/activity_comentario_0", br.com.southsystem.hackatona2019.R.layout.activity_comentario);
      sKeys.put("layout/activity_dados_0", br.com.southsystem.hackatona2019.R.layout.activity_dados);
      sKeys.put("layout/activity_historico_0", br.com.southsystem.hackatona2019.R.layout.activity_historico);
      sKeys.put("layout/activity_recursos_0", br.com.southsystem.hackatona2019.R.layout.activity_recursos);
      sKeys.put("layout/item_lista_0", br.com.southsystem.hackatona2019.R.layout.item_lista);
    }
  }
}
