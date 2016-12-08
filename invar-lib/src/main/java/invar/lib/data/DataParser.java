/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib.data;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wangkang on 12/7/16
 */
public interface DataParser {

    DataNode parse(String content) throws IOException;

    DataNode parse(InputStream input) throws IOException;

}
