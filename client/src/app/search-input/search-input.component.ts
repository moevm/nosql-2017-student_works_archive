import {Component, OnInit} from '@angular/core';
import {Options} from '../data/options';


@Component({
  selector: 'app-search-input',
  templateUrl: './search-input.component.html',
  styleUrls: ['./search-input.component.css']
})
export class SearchInputComponent implements OnInit {

  list: string[];
  options: Options[];
  opt: Options;
  searchParameter: string;
  searchText: string;

  constructor() {
    this.options = [{
      'name': 'Название',
      'param': 'title'
    },
      {
        'name': 'Студент',
        'param': 'studentName'
      },
      {
        'name': 'Преподаватель',
        'param': 'teacherName'
      },
      {
        'name': 'Предмет',
        'param': 'subject'
      },
      {
        'name': 'Группа',
        'param': 'group'
      }] as Options[];
  }

  ngOnInit() {
  }

  submit(action) {
    console.log(action);
  }

  getOption(value) {
    this.searchParameter = value;
    console.log(this.searchText);
  }
}
