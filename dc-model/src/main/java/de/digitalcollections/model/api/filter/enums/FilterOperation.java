package de.digitalcollections.model.api.filter.enums;

/**
 *
 *
 * <table border="1">
 * <caption>Mapping operation abbreviation to filter operation</caption>
 * <tr><th>Symbol</th><th>Operation</th><th>Example filter query param</th></tr>
 * <tr><td>eq       </td><td> Equals                     </td><td>city=eq:Munich	  </td></tr>
 * <tr><td>neq      </td><td> Not Equals                 </td><td>country=neq:de          </td></tr>
 * <tr><td>gt       </td><td> Greater Than               </td><td>amount=gt:10000         </td></tr>
 * <tr><td>gte      </td><td> Greater Than or equals to  </td><td>amount=gte:10000        </td></tr>
 * <tr><td>lt       </td><td> Less Than                  </td><td>amount=lt:10000         </td></tr>
 * <tr><td>lte      </td><td> Less Than or equals to     </td><td>amount=lte:10000        </td></tr>
 * <tr><td>in       </td><td> IN                         </td><td>country=in:uk, usa, au  </td></tr>
 * <tr><td>nin      </td><td> Not IN                     </td><td>country=nin:fr, de, nz  </td></tr>
 * <tr><td>btn      </td><td> Between                    </td><td>joiningDate=btn:2018-01-01, 2016-01-01</td></tr>
 * <tr><td>like     </td><td> Like                       </td><td>firstName=like:John     </td></tr>
 * </table>
 */
public enum FilterOperation {
  EQUAL("eq"),
  NOT_EQUAL("neq"),
  GREATER_THAN("gt"),
  GREATER_THAN_OR_EQUAL_TO("gte"),
  LESS_THAN("lt"),
  LESSTHAN_OR_EQUAL_TO("lte"),
  IN("in"),
  NOT_IN("nin"),
  BETWEEN("btn"),
  CONTAINS("like");

  private final String value;

  FilterOperation(String value) {
    this.value = value;
  }

  @Override
  //	@JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  public static FilterOperation fromValue(String value) {
    for (FilterOperation op : FilterOperation.values()) {

      // Case insensitive operation name
      if (String.valueOf(op.value).equalsIgnoreCase(value)) {
        return op;
      }
    }
    return null;
  }
}
