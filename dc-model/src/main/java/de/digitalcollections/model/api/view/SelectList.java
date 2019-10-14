package de.digitalcollections.model.api.view;

import java.util.List;

/** A List with a title, selectable options and one dedicated option, which is selected. */
public interface SelectList {

  String getTitle();

  void setTitle(String title);

  SelectOption getSelectedOption();

  void setSelectedOption(SelectOption selectedOption);

  List<SelectOption> getOptions();

  void setOptions(List<SelectOption> options);

  void addOption(SelectOption option);
}
