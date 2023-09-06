import { Component, Input } from '@angular/core';


@Component({
  selector: 'app-center',
  templateUrl: './center.component.html',
  styleUrls: ['./center.component.scss'],
})
export class CenterComponent {
  @Input() title: string ="title";
  @Input() firstParagraph:string = "first";
  @Input() secondParagraph:string ="second";
  //TODO: get default browser value
  @Input() language:string = "es"

  headers = new Headers({
    'Accept-Language': this.language, // Specify the preferred language (e.g., English)
    'Content-Type': 'application/json', // Specify the content type if needed
    // Add any other headers you require
  });

  constructor() {
    this.getTitle();
  }

  getTitle() {
    console.log('the language is',this.language);
    console.log(this.title);
    console.log(this.firstParagraph);
    console.log(this.secondParagraph);
    console.log(this.headers);
    fetch('http://localhost:8080/landingpage/title', {
      method: 'GET',
      headers: this.headers,
    })
      .then((response) => {
        // Check if the response status is OK (200)
        if (response.ok) {
          // Parse the response body as text
          return response.text();
        } else {
          throw new Error('Network response was not ok');
        }
      })
      .then((data) => {
        // Assign the fetched string to a variable
        this.title = data;
        console.log('Fetched String:', this.title);
      })
      .catch((error) => {
        console.error('Fetch Error:', error);
      });
  }
}
