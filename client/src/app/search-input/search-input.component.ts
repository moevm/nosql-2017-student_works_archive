import {Component, Input, OnInit} from '@angular/core';
import {Options} from '../data/options';
import {HttpService} from "../service/http.service";
import {Archive} from "../data/archive";
import "rxjs/add/operator/map";


@Component({
  selector: 'app-search-input',
  templateUrl: './search-input.component.html',
  styleUrls: ['./search-input.component.css'],
  providers: [HttpService]
})
export class SearchInputComponent implements OnInit {

  options: Options[];
  searchParameter: string;
  searchText: string;
  url = 'api/files';
  archive: Archive[];

  constructor(private httpService: HttpService) {
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
    const param = new URLSearchParams();
    param.set(this.searchParameter, this.searchText);
    this.httpService.getData(this.url + this.searchParameter, param)
      .map(resp => resp.json() as Archive[])
      .subscribe((data) => {
          this.archive = data;
        },
        error => {
          console.log(error);
        });
  }

  getOption(value) {
    this.searchParameter = value;
    console.log(this.searchText);
  }

  setText(value) {
    this.searchText = value;
  }
}
