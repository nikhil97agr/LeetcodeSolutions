# Migration classification — Batch 001

Branch: `organize/difficulty-batch-001`
Source: `src/`
Scope: first 50 eligible problem folders in alphabetical order with a Markdown statement and at least one Java/Python/C++/Go implementation.

Classification rule: 70% inherent problem challenge + 30% actual implementation complexity; LeetCode labels, acceptance rate and popularity were not used. Every item in this batch is algorithmic and therefore belongs under `Algorithm/`. Original `src/` folders are retained.

| # | Problem folder | Score | Assigned difficulty | Reason | Files copied |
|---:|---|---:|---|---|---:|
| 1 | `a_number_after_a_double_reversal_2238` | 12 | Easy | Direct digit/property observation; constant-time check. | 2 |
| 2 | `abbreviating_the_product_of_a_range_2222` | 78 | Hard | Large-product abbreviation needs leading/trailing digit tracking and trailing-zero handling. | 2 |
| 3 | `absolute_difference_between_maximum_and_minimum_k_elements_4158` | 31 | Easy | Straightforward top/bottom-k selection; small constraints. | 2 |
| 4 | `account_balance_after_rounded_purchase_2955` | 8 | Easy | Simple nearest-ten arithmetic and boundary handling. | 2 |
| 5 | `accounts_merge_721` | 53 | Medium | Email-based connected components with union-find and sorted output. | 2 |
| 6 | `add_binary_67` | 29 | Easy | Standard digitwise addition with carry across unequal lengths. | 2 |
| 7 | `add_bold_tag_in_string_616` | 69 | Hard | Multiple-pattern matching via KMP plus overlapping/adjacent interval consolidation. | 2 |
| 8 | `add_digits_258` | 18 | Easy | Repeated digit-sum arithmetic with a simple loop. | 2 |
| 9 | `add_edges_to_make_degrees_of_all_nodes_even_2596` | 59 | Medium | Parity reasoning and exhaustive cases over up to four odd-degree vertices. | 2 |
| 10 | `add_minimum_number_of_rungs_2066` | 27 | Easy | Single-pass greedy gap formula. | 2 |
| 11 | `add_one_row_to_tree_623` | 39 | Medium | Depth-aware tree recursion with root insertion and subtree preservation. | 2 |
| 12 | `add_strings_415` | 27 | Easy | Elementary decimal string addition with carry. | 2 |
| 13 | `add_to_array_form_of_integer_1031` | 30 | Easy | Digitwise addition across array and scalar representations. | 2 |
| 14 | `add_two_integers_2383` | 2 | Easy | Direct integer addition. | 2 |
| 15 | `add_two_numbers_2` | 32 | Easy | Linked-list traversal with elementary carry propagation. | 2 |
| 16 | `add_two_numbers_ii_445` | 39 | Medium | Reverse-order processing via stacks and carry propagation. | 2 |
| 17 | `add_two_polynomials_represented_as_linked_lists_1774` | 43 | Medium | Combine ordered polynomial terms and discard zero coefficients. | 2 |
| 18 | `adding_spaces_to_a_string_2232` | 17 | Easy | Single linear scan with ordered insertion indices. | 2 |
| 19 | `adding_two_negabinary_numbers_1148` | 63 | Medium | Non-standard negative-base carry transitions and normalization. | 2 |
| 20 | `additive_number_306` | 55 | Medium | Search over initial partitions and validate a sequence with large-integer arithmetic. | 2 |
| 21 | `adjacent_increasing_subarrays_detection_i_3612` | 24 | Easy | Direct bounded scan for two adjacent increasing windows. | 2 |
| 22 | `adjacent_increasing_subarrays_detection_ii_3619` | 48 | Medium | Track increasing-run lengths to derive the maximum adjacent window. | 2 |
| 23 | `advantage_shuffle_901` | 51 | Medium | Greedy assignment after sorting, with ordering of opponent values. | 2 |
| 24 | `aggregate_two_time_series_4338` | 47 | Medium | Ordered timestamp merge with next-available-value semantics. | 2 |
| 25 | `airplane_seat_assignment_probability_1362` | 37 | Medium | Requires recognizing a probability recurrence/symmetry invariant. | 2 |
| 26 | `alert_using_same_key_card_three_or_more_times_in_a_one_hour_period_1709` | 31 | Easy | Group times by person, sort, and inspect consecutive triples. | 2 |
| 27 | `alice_and_bob_playing_flower_game_3279` | 30 | Easy | Parity counting reduces the game outcome to a constant-time formula. | 2 |
| 28 | `alien_dictionary_269` | 70 | Hard | Infer precedence constraints, reject invalid prefixes/cycles, and topologically order characters. | 2 |
| 29 | `all_ancestors_of_a_node_in_a_directed_acyclic_graph_1431` | 56 | Medium | Topological propagation of ancestor sets through a DAG. | 2 |
| 30 | `all_divisions_with_the_highest_score_of_a_binary_array_2261` | 30 | Easy | Prefix counts evaluate every split in linear time. | 2 |
| 31 | `all_elements_in_two_binary_search_trees_1427` | 26 | Easy | Tree traversal followed by sorting; basic tree processing. | 2 |
| 32 | `all_nodes_distance_k_in_binary_tree_893` | 50 | Medium | Convert parent-child links to an undirected graph and BFS from the target. | 2 |
| 33 | `all_oone_data_structure_432` | 82 | Hard | Dynamic min/max frequency structure with strict O(1) operation requirements. | 2 |
| 34 | `all_paths_from_source_lead_to_destination_511` | 58 | Medium | DFS must detect cycles and ensure every reachable path terminates at destination. | 2 |
| 35 | `all_paths_from_source_to_target_813` | 42 | Medium | Backtracking enumeration of paths in a DAG. | 2 |
| 36 | `all_possible_full_binary_trees_930` | 49 | Medium | Recursive combinatorial construction with memoized subtree combinations. | 2 |
| 37 | `allocate_mailboxes_1571` | 72 | Hard | Partition DP over sorted houses with median-based group costs. | 2 |
| 38 | `alphabet_board_path_1238` | 25 | Easy | Coordinate mapping and deterministic movement, including the irregular final row. | 2 |
| 39 | `alt_and_tab_simulation_3538` | 55 | Medium | Maintain mutable order with indexed nodes in a custom doubly linked list. | 2 |
| 40 | `alternating_digit_sum_2630` | 18 | Easy | Simple digit extraction and alternating signs. | 2 |
| 41 | `alternating_groups_i_3463` | 20 | Easy | Check each circular triple directly. | 2 |
| 42 | `alternating_groups_ii_3483` | 48 | Medium | Circular sliding-window/run-length accounting. | 2 |
| 43 | `alternating_groups_iii_3527` | 86 | Hard | Online updates and size queries over circular alternating runs using ordered intervals and a segment tree. | 2 |
| 44 | `ambiguous_coordinates_834` | 57 | Medium | Backtracking over split points and decimal placements with leading/trailing-zero validity rules. | 2 |
| 45 | `amount_of_new_area_painted_each_day_2297` | 72 | Hard | Maintain and merge covered intervals while measuring newly covered portions. | 2 |
| 46 | `amount_of_time_for_binary_tree_to_be_infected_2461` | 49 | Medium | Model tree adjacency and perform multi-directional BFS from the start node. | 2 |
| 47 | `analyze_user_website_visit_pattern_1108` | 60 | Medium | Generate per-user ordered triples, deduplicate per user, and rank patterns with tie-breaking. | 2 |
| 48 | `android_unlock_patterns_351` | 54 | Medium | Backtracking over a constrained state space with skip dependencies and symmetry. | 2 |
| 49 | `angle_between_hands_of_a_clock_1446` | 18 | Easy | Direct angle arithmetic and minimum circular difference. | 2 |
| 50 | `angles_of_a_triangle_4266` | 30 | Easy | Triangle inequality plus the cosine rule for three sides. | 2 |

Batch totals: 50 problem folders; 100 files copied.
Verification: destination entries are built from the exact source blob SHAs; source paths are unchanged. Full tree verification follows the commit.


# Migration classification — Batch 002 (checkpoint 1)

Batch scope: alphabetical eligible problem folders 51–150 (planned 100); this checkpoint completes problems 51–70.

Classification: 70% inherent problem challenge + 30% actual implementation complexity. LeetCode's label is used only as a tie-breaker for genuinely borderline cases. All 20 reviewed here are algorithmic and go under `Algorithm/`. Source folders are retained unchanged.

| # | Problem folder | Score | Assigned difficulty | Reason | Files copied |
|---:|---|---:|---|---|---:|
| 51 | `ant_on_the_boundary_3311` | 20 | Easy | Single-pass accumulation of movement; check whether the running position crosses the boundary. | 2 |
| 52 | `append_characters_to_string_to_make_subsequence_2572` | 20 | Easy | Two-pointer subsequence scan; only count unmatched target suffix characters. | 2 |
| 53 | `append_k_integers_with_minimal_sum_2305` | 43 | Medium | Greedy selection of smallest allowed positive integers while excluding a set; arithmetic-series handling. | 2 |
| 54 | `apple_redistribution_into_boxes_3334` | 12 | Easy | Sort capacities and greedily take largest boxes until the required total is reached. | 2 |
| 55 | `apply_bitwise_operations_to_make_strings_equal_2632` | 27 | Easy | Bitwise reachability reduces to checking whether both strings contain a one. | 2 |
| 56 | `apply_discount_every_n_orders_1459` | 42 | Medium | Stateful cashier object combines product-price lookup, bill aggregation and periodic customer state. | 2 |
| 57 | `apply_discount_to_prices_2373` | 37 | Medium | Token validation and monetary formatting require careful parsing and exact two-decimal output. | 2 |
| 58 | `apply_operations_on_array_to_maximize_sum_of_squares_3153` | 72 | Hard | Bit-count redistribution across k constructed values maximizes a nonlinear sum under bitwise invariants. | 2 |
| 59 | `apply_operations_to_an_array_2551` | 22 | Easy | Sequential adjacent updates followed by stable zero compaction. | 2 |
| 60 | `apply_operations_to_make_all_array_elements_equal_to_zero_2878` | 48 | Medium | Greedy forced window operations with a running expiration count; linear-time invariant maintenance. | 2 |
| 61 | `apply_operations_to_make_string_empty_3308` | 36 | Medium | Frequency maxima plus last-occurrence ordering; moderate counting and ordering reasoning. | 2 |
| 62 | `apply_operations_to_make_sum_of_array_greater_than_or_equal_to_k_3328` | 34 | Easy | Optimize a simple increment-versus-duplicate tradeoff using a direct arithmetic search. | 2 |
| 63 | `apply_operations_to_make_two_strings_equal_3033` | 73 | Hard | Minimum-cost pairing of mismatch positions with local and global operations; nontrivial DP/optimization reasoning. | 2 |
| 64 | `apply_operations_to_maximize_frequency_score_3196` | 68 | Hard | Sort, prefix sums, median-cost windows and binary search over feasible frequency. | 2 |
| 65 | `apply_operations_to_maximize_score_3001` | 76 | Hard | Prime-factor scoring, asymmetric monotonic boundaries and greedy exponentiation over subarray contributions. | 2 |
| 66 | `apply_substitutions_3825` | 43 | Medium | Recursive dependency expansion over an acyclic replacement graph; nested substitutions and expansion order. | 2 |
| 67 | `arithmetic_slices_413` | 29 | Easy | Count extensions of contiguous equal-difference runs with a simple linear recurrence. | 2 |
| 68 | `arithmetic_slices_ii_subsequence_446` | 74 | Hard | Count arithmetic subsequences using pairwise differences and dynamic programming across index pairs. | 2 |
| 69 | `arithmetic_subarrays_1752` | 44 | Medium | For each range, verify a rearrangeable arithmetic progression using extrema, expected spacing and set membership. | 2 |
| 70 | `armstrong_number_1090` | 15 | Easy | Digit extraction and fixed-power summation with a direct comparison. | 2 |

Checkpoint totals: 20 problem folders; 40 files copied. Next problem to process: **71**. Batch 002 remains open through problem 150.
