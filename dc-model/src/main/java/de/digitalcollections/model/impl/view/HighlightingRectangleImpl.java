package de.digitalcollections.model.impl.view;

import de.digitalcollections.model.api.view.HighlightingRectangle;
import java.io.Serializable;
import java.util.Objects;

public class HighlightingRectangleImpl implements Serializable, HighlightingRectangle {

  private final double ulx;

  private final double uly;

  private final double lrx;

  private final double lry;

  private final int ref;

  private final String keywords;

  public HighlightingRectangleImpl(String keywords, int ref, double ulx, double uly, double lrx, double lry) {
    this.ulx = ulx;
    this.uly = uly;
    this.lrx = lrx;
    this.lry = lry;
    this.ref = ref;
    this.keywords = keywords;
  }

  @Override
  public String getKeywords() {
    return keywords;
  }

  @Override
  public int getRef() {
    return ref;
  }

  @Override
  public double getUlx() {
    return ulx;
  }

  @Override
  public double getUly() {
    return uly;
  }

  @Override
  public double getLrx() {
    return lrx;
  }

  @Override
  public double getLry() {
    return lry;
  }

  @Override
  public String toString() {
    return "HighlightingRectangleImpl{"
        + "keywords='" + keywords + '\''
        + ", ulx=" + ulx
        + ", uly=" + uly
        + ", lrx=" + lrx
        + ", lry=" + lry
        + ", ref=" + ref
        + '}';
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 31 * hash + (int) (Double.doubleToLongBits(this.ulx) ^ (Double.doubleToLongBits(this.ulx) >>> 32));
    hash = 31 * hash + (int) (Double.doubleToLongBits(this.uly) ^ (Double.doubleToLongBits(this.uly) >>> 32));
    hash = 31 * hash + (int) (Double.doubleToLongBits(this.lrx) ^ (Double.doubleToLongBits(this.lrx) >>> 32));
    hash = 31 * hash + (int) (Double.doubleToLongBits(this.lry) ^ (Double.doubleToLongBits(this.lry) >>> 32));
    hash = 31 * hash + this.ref;
    hash = 31 * hash + Objects.hashCode(this.keywords);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final HighlightingRectangle other = (HighlightingRectangle) obj;
    if (Double.doubleToLongBits(this.ulx) != Double.doubleToLongBits(other.getUlx())) {
      return false;
    }
    if (Double.doubleToLongBits(this.uly) != Double.doubleToLongBits(other.getUly())) {
      return false;
    }
    if (Double.doubleToLongBits(this.lrx) != Double.doubleToLongBits(other.getLrx())) {
      return false;
    }
    if (Double.doubleToLongBits(this.lry) != Double.doubleToLongBits(other.getLry())) {
      return false;
    }
    if (this.ref != other.getRef()) {
      return false;
    }
    return Objects.equals(this.keywords, other.getKeywords());
  }

}
