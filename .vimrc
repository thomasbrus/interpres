" Place this in your ~/.vimrc
" set exrc            " enable per-directory .vimrc files
" set secure          " disable unsafe commands in local .vimrc files

" Treat *.interpres as Clojure
autocmd BufRead,BufNewFile *.interpres set filetype=clojure

