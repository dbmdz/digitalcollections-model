package de.digitalcollections.model.impl.view;

import de.digitalcollections.model.api.view.SelectList;
import de.digitalcollections.model.api.view.SelectOption;
import java.util.LinkedList;
import java.util.List;

public class SelectListImpl implements SelectList {

  String title;
  SelectOption selectedOption;
  List<SelectOption> options = new LinkedList<>();

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public SelectOption getSelectedOption() {
    return selectedOption;
  }

  @Override
  public void setSelectedOption(SelectOption selectedOption) {
    this.selectedOption = selectedOption;
  }

  @Override
  public List<SelectOption> getOptions() {
    return options;
  }

  @Override
  public void setOptions(List<SelectOption> options) {
    if (options != null) {
      this.options = options;
    }
  }

  @Override
  public void addOption(SelectOption option) {
    options.add(option);
  }

  @Override
  public String toString() {
    return "SelectListImpl{"
        + "title='"
        + title
        + '\''
        + ", selectedOption="
        + selectedOption
        + ", options="
        + options
        + '}';
  }
}
