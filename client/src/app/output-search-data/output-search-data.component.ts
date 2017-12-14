import {Component, Input, OnInit} from '@angular/core';
import {Archive} from '../data/archive';
import {SharedService} from "../service/shared/shared.service";

@Component({
  selector: 'app-output-search-data',
  templateUrl: './output-search-data.component.html',
  styleUrls: ['./output-search-data.component.css']
})

export class OutputSearchDataComponent implements OnInit {

  @Input() archiveFiles: Archive[];

  constructor(private shared: SharedService) {
  }

  ngOnInit() {
  }

  setArchive(file: Archive) {
    this.shared.setCurrent(file);
  }
}
