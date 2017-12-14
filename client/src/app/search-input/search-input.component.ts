import {Component, Input, OnInit} from '@angular/core';
import {Options} from '../data/options';
import {HttpService} from "../service/http/http.service";
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
  url = 'http://localhost:8090/api/files';
  archive: Archive[];
  archiveBody: Archive;

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
    this.searchText='';
    this.searchParameter='title';
    this.archiveBody=new Archive();
    this.archiveBody.title="12";
    this.archiveBody.group="4383";
    console.log(this.archiveBody);
  }

  ngOnInit() {
  }

  submit(action) {
    // const param = new URLSearchParams();
    // param.set(this.searchParameter, this.searchText.toString());
    // this.httpService.getData(this.url + '/'+this.searchParameter, param.toString())
    //   .map(resp => resp.json() as Archive[])
    //   .subscribe((data) => {
    //       this.archive = data;
    //     },
    //     error => {
    //       console.log(error);
    //     });
    this.httpService.postBody(JSON.stringify(this.archiveBody), this.url)
      //.map(resp => resp.json() as Archive[])
      .subscribe((data) => {
          console.log(data);
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
