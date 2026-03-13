import React, { useState } from "react";
import axios from "axios";
import "../App.css";

function UploadCSV() {

  const [file, setFile] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleFileChange = (e) => {
    setFile(e.target.files[0]);
  };

  const handleUpload = async () => {

    if (!file) {
      alert("Please select a CSV file");
      return;
    }

    const formData = new FormData();
    formData.append("file", file);

    try {

      setLoading(true);

      const response = await axios.post(
        "http://localhost:8080/api/csv/upload",
        formData,
        { responseType: "blob" }
      );

      const url = window.URL.createObjectURL(new Blob([response.data]));

      const link = document.createElement("a");
      link.href = url;
      link.setAttribute("download", "result.csv");

      document.body.appendChild(link);
      link.click();

      setLoading(false);

    } catch (error) {
      console.error(error);
      alert("Error processing file");
      setLoading(false);
    }
  };

  return (
    <div className="container">
      <div className="card">

        <h2 className="title">Student CSV Processor</h2>

        <input 
          type="file" 
          accept=".csv"
          className="file-input"
          onChange={handleFileChange}
        />

        <br />

        <button className="button" onClick={handleUpload}>
          Process CSV
        </button>

        {loading && <p className="loading">Processing file...</p>}

      </div>
    </div>
  );
}

export default UploadCSV;