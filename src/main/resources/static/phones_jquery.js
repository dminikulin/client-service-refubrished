const PHONES_TAB = `
<table class="table">
    <tr>
        <th>ID</th>
        <th>Phone</th>
    </tr>
    {{#phones}}
    <tr>
        <td>{{id}}</td>
        <td>{{phone}}</td>
    </tr>
    {{/phones}}
</table>
`

$(document).ready(function (){
    $('#loadButton').click(function (event){
        event.preventDefault()
        ajaxSubmitForm()
    })
})

function ajaxSubmitForm(){
    let form=$('#phoneForm')[0]
    let formData=new FormData(form)
    let json=JSON.stringify(Object.fromEntries(formData))
    $.ajax({
        type: 'post',
        url: '/rest/phoneForm',
        data: json,
        processData: false,
        contentType: 'application/json; charset=utf-8',
        success:function(data, textStatus, jqXHR){
            let phones = JSON.parse(jqXHR.responseText)
            phones={
                'phones':phones
            }
            let result=mustache.render(PHONES_TAB, phones)
            $('#output').html(result)
        },
        error:function(jqXHR, textStatus, errorThrown){
            alert(textStatus)
        }
    })
}