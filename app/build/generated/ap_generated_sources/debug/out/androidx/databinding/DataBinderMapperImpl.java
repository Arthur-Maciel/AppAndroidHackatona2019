package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new br.com.southsystem.hackatona2019.DataBinderMapperImpl());
  }
}
