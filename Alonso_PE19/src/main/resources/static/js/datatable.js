$(document).ready( function () {
	 var table = $('#desmatriculados').DataTable({
			"sAjaxSource": "",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "id"},
		      { "mData": "name" },
				  { "mData": "Nombre",
		    	  "mData":"Curso"}
				 
			]
	 })
});

$(document).ready( function () {
	 var table = $('#eliminados').DataTable({
			"sAjaxSource": "",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "id"},
		      { "mData": "name" },
				  { "mData": "Nombre"}
				 
			]
	 })
});