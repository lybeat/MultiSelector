## MultiSelector
MultiSelector is an Android multi selector library.

## Feature
1. Quickly add a multiple selector for your project.
2. Back in real time all the options.
3. Support custom the selector background and option background.

## Demo

## Gradle Dependency
    compile 'com.lybeat:multi-selector:1.0.0'

## Usage
* STEP1:

  Introduced the MultiSelector to your layout file

    <com.lybeat.library.MultiSelector
            android:id="@+id/multi_selector"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            lybeat:optionBackground="@drawable/bg_item_option_pressed"
            lybeat:selectorBackground="#ffffff" />

* STEP2:

  Init BaseOption and MultiSelector in Java code. And set OnSelectListener for MultiSelector.

  Init BaseOption sample:

      List<String> options1 = new ArrayList<>();
      options1.add("全部");
      options1.add("TV版");
      options1.add("OVA.OAD");
      options1.add("剧场版");
      BaseOption baseOption1 = new BaseOption();
      baseOption1.options(options1).select(0);

      List<String> options2 = new ArrayList<>();
      options2.add("全部");
      options2.add("日本");
      options2.add("大陆");
      options2.add("其他");
      BaseOption baseOption2 = new BaseOption();
      baseOption2.options(options2).select(0);

      List<BaseOption> baseOptions = new ArrayList<>();
      baseOptions.add(baseOption1);
      baseOptions.add(baseOption2);

  Init MultiSelector and set OnSelectListener:

      MultiSelector multiSelector = (MultiSelector) findViewById(R.id.multi_selector);
      multiSelector.addBaseOptions(baseOptions);
      multiSelector.setOnSelectListener(this);

## License
Copyright 2016 lybeat

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.