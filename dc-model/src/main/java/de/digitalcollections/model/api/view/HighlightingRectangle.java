package de.digitalcollections.model.api.view;

public interface HighlightingRectangle {

  String getKeywords();

  int getRef();

  double getUlx();

  double getUly();

  double getLrx();

  double getLry();
}
