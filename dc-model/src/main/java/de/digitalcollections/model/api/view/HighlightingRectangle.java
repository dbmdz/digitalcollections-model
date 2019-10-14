package de.digitalcollections.model.api.view;

import java.io.Serializable;

/**
 * A rectangle (defined by its upper left and lower right coordinates) for highlighted text
 * including the text itself.
 */
public interface HighlightingRectangle extends Serializable {

  /**
   * The text to be highlighted (e.g. for plaintext representation)
   *
   * @return the text
   */
  String getText();

  /**
   * The reference of the highlight rectangle, e.g. a page number
   *
   * @return the value of the reference
   */
  int getRef();

  /**
   * The relative abscissa (x) of the upper left point of the rectangle
   *
   * @return a value in the range [0..1]
   */
  double getUlx();

  /**
   * The relative ordinate (y) of the upper left point of the rectangle
   *
   * @return a value in the range [0..1]
   */
  double getUly();

  /**
   * the relative abscissa of the lower right point of the rectangle
   *
   * @return a value in the range [0..1]
   */
  double getLrx();

  /**
   * the relative ordinate of the lower right point of the rectangle
   *
   * @return a value in the range [0..1]
   */
  double getLry();
}
