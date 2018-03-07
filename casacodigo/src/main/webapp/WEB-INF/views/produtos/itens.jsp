<td class="remove-item">
    <form action="${s:mvcUrl('CCC#remover').arg(0, item.produto.id).arg(1,item.tipoPreco).build() }" method="post">
        <input type="image" src="/excluir.png" alt="Excluir" title="Excluir" />
    </form>
</td>