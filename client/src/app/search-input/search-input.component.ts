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
  url = 'http://localhost:8090/api/files/find';
  archive: Archive[];
  archiveBody: Archive;

  constructor(private httpService: HttpService) {
    this.searchText = '';
    this.searchParameter = 'title';
    this.archiveBody = new Archive();
    this.archiveBody.title = null;
    this.archiveBody.group = null;
    this.archiveBody.id = null;
    this.archiveBody.subject = null;
    this.archiveBody.grade = null;
    this.archiveBody.teacherName = null;
    this.archiveBody.studentId = null;
    this.archiveBody.studentName = null;
    this.archiveBody.file = null;
    this.archiveBody.date = null;
  }

  ngOnInit() {
  }

  submit(action) {
    this.httpService.postBody(this.archiveBody, this.url)
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
