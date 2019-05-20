package com.richemont.dms.catalog;

import java.util.List;

public interface DataAccessObject<T> {
    List<T> list(int count, int offset);
}
